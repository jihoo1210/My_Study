package seboard.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int id;
	private String pass;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private Timestamp createAt;
}
