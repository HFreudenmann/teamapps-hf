package org.teamapps.icons;

import org.teamapps.icons.spi.IconDecoder;
import org.teamapps.icons.spi.IconEncoder;
import org.teamapps.icons.spi.IconLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * TeamApps session-specific icon provider. Allows for custom (session-specific) default styles per icon library.
 */
public class SessionIconProvider {

	private final IconProvider iconProvider;

	private final Map<Class<? extends Icon>, Object> defaultStyleByIconClass = new HashMap<>();

	public SessionIconProvider(IconProvider iconProvider) {
		this.iconProvider = iconProvider;
	}

	public <I extends Icon<I, S>, S> String encodeIcon(I icon) {
		return encodeIcon(icon, false);
	}

	public <I extends Icon<I, S>, S> String encodeIcon(I icon, boolean fallbackToDefaultStyle) {
		IconEncoder encoder = iconProvider.getIconEncoder(icon.getClass());

		if (icon.getStyle() == null && fallbackToDefaultStyle) {
			S style =  (S) defaultStyleByIconClass.computeIfAbsent(icon.getClass(), iClass -> iconProvider.getDefaultStyle(iClass));
			icon = icon.withStyle(style);
		}

		return iconProvider.getLibraryName(icon) + "."
				+ encoder.encodeIcon(icon, i -> encodeIcon((Icon) i, fallbackToDefaultStyle));
	}

	public Icon<?, ?> decodeIcon(String qualifiedEncodedIconString) {
		return iconProvider.decodeIcon(qualifiedEncodedIconString);
	}

	public IconResource loadIcon(String qualifiedEncodedIconString, int size) {
		return iconProvider.loadIcon(qualifiedEncodedIconString, size);
	}

	public IconResource loadIcon(Icon<?, ?> icon, int size) {
		return iconProvider.loadIcon(icon, size);
	}

	public <I extends Icon<I, S>, S> void registerIconLibrary(Class<I> iconClass) {
		iconProvider.registerIconLibrary(iconClass);
	}

	public <I extends Icon<I, S>, S> void registerIconLibrary(Class<I> iconClass, String libraryName, IconEncoder<I, S> iconEncoder, IconDecoder<I, S> iconDecoder, IconLoader<I, S> iconLoader, S defaultStyle) {
		iconProvider.registerIconLibrary(iconClass, libraryName, iconEncoder, iconDecoder, iconLoader, defaultStyle);
	}

	public <I extends Icon<I, S>, S> void setDefaultStyleForIconClass(Class<I> iconClass, S defaultStyle) {
		iconProvider.registerIconLibrary(iconClass);
		defaultStyleByIconClass.put(iconClass, defaultStyle);
	}

}