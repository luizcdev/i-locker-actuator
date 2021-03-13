package com.luizcdev.ilockeractuator.dto;

import lombok.Data;

@Data
public class ResponseBodyDTO<T> {
		
	private T result;	
	
	public ResponseBodyDTO(T result) {
		this.result = result;		
	}

}
