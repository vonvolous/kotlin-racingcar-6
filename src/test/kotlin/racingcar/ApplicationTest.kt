package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `사용자 입력값에 대한 예외 처리`() {
        assertThrows<IllegalArgumentException> { runException("pobi,newbi,vonvolous", "3") }
    }

    @Test
    fun `자동차 클래스 및 출력 기능 확인`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni,vonvo", "1")
                    assertThat(output()).contains("pobi : -", "woni : ", "vonvo : -", "최종 우승자 : pobi,vonvo")
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
