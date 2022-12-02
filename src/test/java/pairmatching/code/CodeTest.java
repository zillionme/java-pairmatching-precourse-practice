package pairmatching.code;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.lhg.codechecker.tool.CodeChecker;

public class CodeTest {

    @Test
    void parameterTest() {
        // given
        // given

        // 메서드(public) 5개까지 제한
        // 필드(클래스, 인스턴스 포함) 4개 제한
        // 파라미터 3개 제한

        CodeChecker codeChecker = CodeChecker.rules()
                .limitFields(4)
                .build();

        // when
        boolean check = codeChecker.checkAll("pairmatching", true);
        // then
        assertThat(check).as(codeChecker.getMessage()).isEqualTo(true);
    }
}