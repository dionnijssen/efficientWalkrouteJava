package Logic.Dtos.src;

public class RuleInformtionDto {
    private Boolean success;
    private String reason;

    public void setSuccess() {
        this.success = true;
        this.reason = "Success";
    }

    public void setFailure (String reason) {
        this.success = false;
        this.reason = reason;
    }

    public Boolean isSuccess() {
        return success;
    }

    public String getReason() {
        return reason;
    }
}
