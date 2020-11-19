package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningRankTest {

    static Stream<Arguments> getWinningRank() {
        return Stream.of(
                arguments(6, WinningRank.FIRST),
                arguments(5, WinningRank.SECOND),
                arguments(4, WinningRank.THIRD),
                arguments(3, WinningRank.FOURTH),
                arguments(2, WinningRank.FAIL),
                arguments(1, WinningRank.FAIL),
                arguments(0, WinningRank.FAIL)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void getWinningRank(int sameNumberCount, WinningRank expectedWinningRank) {
        WinningRank winningRank = WinningRank.getWinningRank(sameNumberCount);

        assertThat(winningRank).isEqualTo(expectedWinningRank);
    }

    @Test
    @DisplayName("일치하는 숫자가 0~6이 아닌 다른 숫자가 들어올 때")
    void getWinningRank_not0to6() {
        assertThatThrownBy(() -> WinningRank.getWinningRank(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Wrong Same Number Count");
    }
}