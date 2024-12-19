package org.example.bank2.DTO;

import lombok.Data;

@Data
public class NomineeRequest {
    private String userId;
    private String nomineeId;

    public NomineeRequest(String userId, String nomineeId) {
        this.userId = userId;
        this.nomineeId = nomineeId;
    }

    public NomineeRequest() {}

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getNomineeId() {
        return nomineeId;

    }
    public void setNomineeId(String nomineeId) {
        this.nomineeId = nomineeId;
    }


}