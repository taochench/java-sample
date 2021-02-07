package com.tcc.sample.service.model;

import lombok.Data;

/**
 * @version $Id 2020年09月12日 10:18 PageQueryAccountRequest.java $Exp
 * @auter taoch
 */
@Data
public class PageQueryAccountRequest extends PageModel {

    public static PageQueryAccountRequest of(int page, int size){
        PageQueryAccountRequest request = new PageQueryAccountRequest();
        request.setPage(page);
        request.setSize(size);
        return request;
    }
}
