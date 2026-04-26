package com.sabtok.service.impl;

import com.sabtok.entity.IncomingLog;
import com.sabtok.records.MessageLog;
import com.sabtok.repository.IncomingLogRepo;
import com.sabtok.service.SaveIncomingLog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SaveIncomingLogI implements SaveIncomingLog {

    @Autowired
     private IncomingLogRepo incomingLogRepo;

     @Override
     public Boolean saveLog(MessageLog message) {
          IncomingLog incomingLog = new IncomingLog();
         /* IncomingLog incomingLog = IncomingLog.builder().
                  message(message.message()).source(message.source())
                  .createdBy("alert-notification")
                  .createdDate(LocalDateTime.now())
                  .build();*/
            incomingLog.setMessage(message.message());
            incomingLog.setSource(message.source());
            incomingLog.setCreatedBy("alert-notification");
            incomingLog.setCreatedDate(LocalDateTime.now());
           incomingLogRepo.save(incomingLog);
          return true;
     }

     @Override
     public List<IncomingLog> getAllLogs() {
          return incomingLogRepo.findAll();
     }
}
