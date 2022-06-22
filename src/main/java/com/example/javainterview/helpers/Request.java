package com.example.javainterview.helpers;

/**
 * Created with IntelliJ IDEA.
 * User: marowak
 * Date: 22.06.2022
 * Time: 0:23
 */
public class Request {
    private String id;

    private Long addressId;
    private Long newPersonId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getNewPersonId() {
        return newPersonId;
    }

    public void setNewPersonId(Long newPersonId) {
        this.newPersonId = newPersonId;
    }
}
