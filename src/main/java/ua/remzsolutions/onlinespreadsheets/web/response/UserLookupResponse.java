package ua.remzsolutions.onlinespreadsheets.web.response;

import ua.remzsolutions.onlinespreadsheets.domain.dto.UserDTO;
import org.springframework.data.domain.Page;

public class UserLookupResponse {

    private Page<UserDTO> page;

    public UserLookupResponse() {
    }

    public UserLookupResponse(Page<UserDTO> page) {
        this.page = page;
    }

    public Page<UserDTO> getPage() {
        return page;
    }

    public UserLookupResponse setPage(Page<UserDTO> page) {
        this.page = page;
        return this;
    }

    @Override
    public String toString() {
        return "UserLookupResponse{" +
                "page=" + page +
                '}';
    }
}
