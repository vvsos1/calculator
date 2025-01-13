import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CalculatorTest  {
    static Calculator c;
    @BeforeEach
    void setUp() {
        c = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        assertThat(c.add(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void add_null_또는_빈문자열() {
        assertThat(c.add(null)).isEqualTo(0);
        assertThat(c.add("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void add_숫자하나() {
        assertThat(c.add("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void add_쉼표구분자() {
        assertThat(c.add("1,2")).isEqualTo(3);
        assertThat(c.add("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void add_쉼표_콜론_구분자() {
        assertThat(c.add("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("입력 값에 따라 계산 순서가 결정")
    void calculate_계산순서() {
        String expression = "2 + 3 * 4 / 2";
        assertThat(c.calculate(expression)).isEqualTo(10);
    }
}