package com.unilearntech.unilearntech.models;


import com.unilearntech.unilearntech.utils.date.DateUtils;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "channelOrderSyncStatus")
public class VideoEncodingSyncStatus implements Serializable {

    private static final long           serialVersionUID    = 8742974020680542729L;

    @Id
    private String                      id;
    private VideoEncodingStatus.SyncExecutionStatus syncExecutionStatus = VideoEncodingStatus.SyncExecutionStatus.IDLE;
    private String                      requestId;
    private String                      message;
    private long                        totalMileStones;
    private long                        currentMileStone;
    private int                         lastSuccessfulImportCount;
    private long                        todaysSuccessfulImportCount;
    private int                         lastFailedImportCount;
    private int                         todaysFailedImportCount;
    private boolean                     lastSyncSuccessful;
    private Date                        lastSyncTime;
    private Date                        lastSyncFailedNotificationTime;
    private Date                        lastSuccessfulOrderReceivedTime;
    private Date                        created;
    private Date                        lastMileStoneUpdateTime;

    public VideoEncodingSyncStatus() {

        this.created = DateUtils.getCurrentTime();
    }
    public VideoEncodingSyncStatus(String requestId) {

        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLastMileStoneUpdateTime() {
        return lastMileStoneUpdateTime;
    }

    public void setLastMileStoneUpdateTime(Date lastMileStoneUpdateTime) {
        this.lastMileStoneUpdateTime = lastMileStoneUpdateTime;
    }

    public float getPercentageComplete() {
        if (totalMileStones == 0) {
            return 0;
        }
        return ((float) (currentMileStone * 10000 / totalMileStones)) / 100;
    }


    public void setSyncExecutionStatus(VideoEncodingStatus.SyncExecutionStatus syncExecutionStatus) {
        this.syncExecutionStatus = syncExecutionStatus;
    }

    public VideoEncodingStatus.SyncExecutionStatus getSyncExecutionStatus() {
        return syncExecutionStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(Date lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public long getTotalMileStones() {
        return totalMileStones;
    }

    public void setTotalMileStones(long totalMileStones) {
        this.totalMileStones = totalMileStones;
    }

    public long getCurrentMileStone() {
        return currentMileStone;
    }

    public void setCurrentMileStone(long currentMileStone) {
        this.currentMileStone = currentMileStone;
    }

    public void reset() {
        syncExecutionStatus = VideoEncodingStatus.SyncExecutionStatus.IDLE;
        message = null;
        totalMileStones = 0;
        currentMileStone = 0;
        lastSyncSuccessful = false;
        lastMileStoneUpdateTime = null;
    }

    public void setMileStone(String message) {
        currentMileStone++;
        lastMileStoneUpdateTime = new Date();
    }

    public int getLastSuccessfulImportCount() {
        return lastSuccessfulImportCount;
    }

    public void setLastSuccessfulImportCount(int lastSuccessfulImportCount) {
        this.lastSuccessfulImportCount = lastSuccessfulImportCount;
    }

    public long getTodaysSuccessfulImportCount() {
        return todaysSuccessfulImportCount;
    }

    public void setTodaysSuccessfulImportCount(long todaysSuccessfulImportCount) {
        this.todaysSuccessfulImportCount = todaysSuccessfulImportCount;
    }

    public int getLastFailedImportCount() {
        return lastFailedImportCount;
    }

    public void setLastFailedImportCount(int lastFailedImportCount) {
        this.lastFailedImportCount = lastFailedImportCount;
    }

    public int getTodaysFailedImportCount() {
        return todaysFailedImportCount;
    }

    public Date getLastSyncFailedNotificationTime() {
        return lastSyncFailedNotificationTime;
    }

    public void setLastSyncFailedNotificationTime(Date lastSyncFailedNotificationTime) {
        this.lastSyncFailedNotificationTime = lastSyncFailedNotificationTime;
    }

    public void setTodaysFailedImportCount(int todaysFailedImportCount) {
        this.todaysFailedImportCount = todaysFailedImportCount;
    }

    public Date getLastSuccessfulOrderReceivedTime() {
        return lastSuccessfulOrderReceivedTime;
    }

    public void setLastSuccessfulOrderReceivedTime(Date lastSuccessfulOrderReceivedTime) {
        this.lastSuccessfulOrderReceivedTime = lastSuccessfulOrderReceivedTime;
    }


    public boolean isLastSyncSuccessful() {
        return lastSyncSuccessful;
    }

    public void setLastSyncSuccessful(boolean lastSyncSuccessful) {
        this.lastSyncSuccessful = lastSyncSuccessful;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}