package net.javaguides.springboot.springboothelloworldtutorial.controller;

import net.javaguides.springboot.springboothelloworldtutorial.entity.*;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.CalenderService;
import net.javaguides.springboot.springboothelloworldtutorial.service.impl.ProductService;
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
import java.sql.Timestamp;
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
        private ProductService productService;
        static Long prod = 1L;

        @GetMapping("/calenders")
        public List<CalenderEmployee> getAllCalender() { //get All Data
            List<CalenderEmployee> list = calenderService.getAllCalender();
            return list;
        }

        @PostMapping("/calenders-by-date")
        public List<CalenderEmployee> getCalenderByDate(Timestamp date, @RequestParam(defaultValue = "") Timestamp to) { //get All Data
            List<CalenderEmployee> list = calenderService.getCalenderByDate(date,to);
            return list;
        }

        @PostMapping("/calenders")
        public ResponseEntity<Object> saveCalender(Calender calender) { // create calender
            try {
                Calender _calender = calenderService.saveCalender(calender);
                Product _product = calenderService.updateCount(calender.getProduct_id(), calender.getCount()); // update the remaining count of products
                return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @PutMapping("/calenders/{id}")
        public ResponseEntity<Object> updateCalender(Calender calender) { //update calender
            try {
                Calender _calender = calenderService.updateCalender(calender);
                return ResponseHandler.generateResponse("Successfully updated  data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @RequestMapping("/deleteCalenderById")
        public ResponseEntity<Object> deleteCalenderById(Long id) { //delete data
            try {
                Calender _calender = calenderService.deleteCalenderById(id);
                return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, null);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @PostMapping("/calenders/export") //export data
        public void exportToCSV(HttpServletResponse response,Timestamp from,Timestamp to) throws IOException {
            response.setContentType("text/csv");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=calenders_" + currentDateTime + ".csv";
            response.setHeader(headerKey, headerValue);

            List<CalenderEmployee> lists = calenderService.getCalenderByDate(from,to);

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
