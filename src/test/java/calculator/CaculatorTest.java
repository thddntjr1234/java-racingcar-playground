package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CaculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void 커스텀_구분자_입력() throws Exception {
        int result = calculator.calculate("//>\n1>2>3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 기본_구분자_입력() throws Exception {
        int result = calculator.calculate("1,2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 숫자_하나만_입력() throws Exception {
        int result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 입력_없음() throws Exception {
        int result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 유효하지_않은_숫자_입력() throws Exception {
        assertThatThrownBy(() -> calculator.calculate("-1,3,a")).isInstanceOf(RuntimeException.class);
    }
}
