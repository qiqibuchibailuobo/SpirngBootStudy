package cn.yq.demo.service;

import cn.yq.demo.exception.AjaxResponse;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {

//    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");
//
//    ResponseToXlsConverter(){
//        super(EXCEL_TYPE);
//    }


    @Override
    protected boolean supports(Class<?> aClass) {

        return (AjaxResponse.class == aClass);
    }

    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
//        final Workbook workbook = new HSSFWorkbook();
//        final Sheet sheet = workbook.createSheet();
//
//        final Row row = sheet.createRow(0);
//        row.createCell(0).setCellValue(ajaxResponse.getMessage());
//        row.createCell(1).setCellValue(ajaxResponse.getData().toString());
//
//        workbook.write(httpOutputMessage.getBody());
    }
}
