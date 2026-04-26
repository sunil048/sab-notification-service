package com.sabtok.service;

import com.sabtok.entity.IncomingLog;
import com.sabtok.records.MessageLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface SaveIncomingLog {
     Boolean saveLog(MessageLog message);
     List<IncomingLog> getAllLogs();
}
