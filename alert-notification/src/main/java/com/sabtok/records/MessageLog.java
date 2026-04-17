package com.sabtok.records;

import java.time.LocalDateTime;

public record MessageLog(int id, String message, LocalDateTime createdDate, String createdBy) {
}
