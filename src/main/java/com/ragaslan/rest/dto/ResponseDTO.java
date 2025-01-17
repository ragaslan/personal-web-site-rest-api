package com.ragaslan.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public  class ResponseDTO <T> {

    public boolean status;
    public T data;

}
