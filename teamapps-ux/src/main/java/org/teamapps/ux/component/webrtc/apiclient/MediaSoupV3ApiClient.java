package org.teamapps.ux.component.webrtc.apiclient;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface MediaSoupV3ApiClient {

	CompletableFuture<Double> getWorkerLoad(int workerId);

	CompletableFuture<Integer> getNumberOfWorkers();

	CompletableFuture<Void> startRecording(String streamUuid);

	CompletableFuture<Void> startRecording(String streamUuid, Set<MediaKind> kinds);

	CompletableFuture<Void> stopRecording(String streamUuid);

	default CompletableFuture<Void> setRecordingEnabled(String streamUuid, boolean enabled) {
		return enabled ? startRecording(streamUuid) : stopRecording(streamUuid);
	}

	CompletableFuture<Void> startFileStreaming(int workerId, StreamFileRequest streamFileRequest);

	CompletableFuture<Void> stopFileStreaming(int workerId, String streamUuid);

	CompletableFuture<List<String>> getRecordedStreamUuids();

	CompletableFuture<List<String>> getStreamRecordingsForUuid(String streamUuid);

	CompletableFuture<Void> deleteStreamRecordings(String streamUuid);

	CompletableFuture<Void> deleteRecording(String recordingName);

	Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	static File downloadVideo(URL url, File downloadDirectory) throws IOException {
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			LOGGER.info("Downloading video: {} to {}", url, downloadDirectory.getAbsolutePath());
			File resultFile = new File(downloadDirectory, FilenameUtils.getName(url.getPath()).replace(':', '-'));
			try (BufferedInputStream is = new BufferedInputStream(con.getInputStream());
			     BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(resultFile, false))) {
				IOUtils.copy(is, os);
			}
			return resultFile;
		} catch (IOException e) {
			LOGGER.error("Exception while downloading video: " + url, e);
			throw e;
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
	}

	static File downloadVideo(String url) throws IOException {
		return downloadVideo(new URL(url), Files.createTempDirectory("download").toFile());
	}
}