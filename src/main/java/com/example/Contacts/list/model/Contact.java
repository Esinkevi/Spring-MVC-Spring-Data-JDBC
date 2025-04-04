package com.example.Contacts.list.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
public class Contact {

    private Long id;

    private String name;

    private String lastName;

    private String phoneNumber;

}
