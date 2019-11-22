package ParallelProgrammingLab4;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect
public class Result {

    @JsonIgnore
    private final String packageId;
    private final String testName;
    private final String expectedResult;
    private final String result;
    private final boolean isSuccessful;
    private
}
