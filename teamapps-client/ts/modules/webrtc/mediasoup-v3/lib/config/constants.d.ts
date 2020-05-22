/*-
 * ========================LICENSE_START=================================
 * TeamApps
 * ---
 * Copyright (C) 2014 - 2020 TeamApps.org
 * ---
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
export declare enum ACTION {
    GET_SERVER_CONFIGS = "getServerConfigs",
    CREATE_TRANSPORT = "createTransport",
    CONNECT_TRANSPORT = "connectTransport",
    CLOSE_TRANSPORT = "closeTransport",
    PRODUCE = "produce",
    CONSUME = "consume",
    RESUME_CONSUMER = "resumeConsumer",
    PAUSE_CONSUMER = "pauseConsumer",
    CLOSE_CONSUMER = "closeConsumer",
    RESUME_PRODUCER = "resumeProducer",
    PAUSE_PRODUCER = "pauseProducer",
    CLOSE_PRODUCER = "closeProducer",
    FILE_STREAMING = "fileStreaming",
    STOP_FILE_STREAMING = "stopFileStreaming",
    START_RECORDING = "startRecording",
    STOP_RECORDING = "stopRecording",
    CREATE_PIPE_TRANSPORT = "createPipeTransport",
    CONNECT_PIPE_TRANSPORT = "connectPipeTransport",
    SET_PREFERRED_LAYERS = "setPreferredLayers",
    SET_MAX_INCOMING_BITRATE = "setMaxIncomingBitrate",
    PRODUCERS_STATS = "producersStats",
    CONSUMERS_STATS = "consumersStats",
    TRANSPORT_STATS = "transportStats",
    PIPE_TO_REMOTE_PRODUCER = "pipeToRemoteProducer",
    PIPE_FROM_REMOTE_PRODUCER = "pipeFromRemoteProducer",
    WORKER_LOAD = "workerLoad",
    NUM_WORKERS = "numWorkers",
    RECORDED_STREAMS = "recordedStreams",
    STREAM_RECORDINGS = "streamRecordings",
    DELETE_STREAM_RECORDINGS = "deleteStreamRecordings",
    DELETE_RECORDING = "deleteRecording",
    PUSH_TO_SERVER_INPUTS = "pushToServerInputs",
    PULL_FROM_SERVER_INPUTS = "pullFromServerInputs"
}
export declare enum PATH {
    RECORDINGS = "recordings",
    MEDIASOUP = "mediasoup",
    FRONT = "front",
    API_DOCS = "api-docs"
}
export declare enum ERROR {
    UNKNOWN = 500,
    UNAUTHORIZED = 401,
    INVALID_TRANSPORT = 530,
    INVALID_PRODUCER = 531,
    INVALID_CONSUMER = 532,
    INVALID_STREAM = 533,
    INVALID_OPERATION = 534,
    INVALID_WORKER = 535
}
export declare enum API_OPERATION {
    SUBSCRIBE = 0,
    PUBLISH = 1
}
