package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.Calender;
import net.javaguides.springboot.springboothelloworldtutorial.entity.CalenderEmployee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Employee;
import net.javaguides.springboot.springboothelloworldtutorial.entity.Inventory;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class CalenderController {

        @Autowired
        private CalenderService calenderService;

        @GetMapping("/calenders")
        public List<CalenderEmployee> getAllCalender() { //get All Data
            List<CalenderEmployee> list = calenderService.getAllCalender();
            return list;
        }

        @PostMapping("/calenders")
        public ResponseEntity<Object> saveCalender(Calender calender) { // create data
            try {
                Inventory _calender = calenderService.saveCalender(calender);
                return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @PutMapping("/calenders/{id}")
        public ResponseEntity<Object> updateCalender(Calender calender) { //update data
            try {
                Inventory _calender = calenderService.updateCalender(calender);
                return ResponseHandler.generateResponse("Successfully updated  data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @RequestMapping("/deleteCalenderById")
        public ResponseEntity<Object> deleteCalenderById(Long id) { //delete data
            try {
                Inventory _calender = calenderService.deleteCalenderById(id);
                return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping("/calenders/export") //export data
        public void exportToCSV(HttpServletResponse response) throws IOException {
            response.setContentType("text/csv");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=calenders_" + currentDateTime + ".csv";
            response.setHeader(headerKey, headerValue);

            List<CalenderEmployee> lists = calenderService.getAllCalender();

            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
            String[] csvHeader = {"count","first name", "datetime"};
            String[] nameMapping = {"count","first_name","datetime"};

            csvWriter.writeHeader(csvHeader);

            for (Calender calender : lists) {
                csvWriter.write(calender, nameMapping);
            }
            csvWriter.close();
        }
}
