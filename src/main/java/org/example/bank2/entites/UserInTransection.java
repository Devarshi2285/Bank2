package org.example.bank2.entites;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInTransection {


        private User user;
        private Account account;
        private String IFSC;
        private String BankName;
        private String BranchName;

        public UserInTransection(User user, Account account, String IFSC, String BankName, String BranchName) {
            this.user = user;
            this.account = account;
            this.IFSC = IFSC;
            this.BankName = BankName;
            this.BranchName = BranchName;
        }

    public Account getAccount() {
        return account;
    }
    public User getUser() {
            return user;
    }
    public String getIFSC() {
            return IFSC;
    }
    public String getBankName() {
            return BankName;
    }
    public String getBranchName() {
            return BranchName;
    }
}
