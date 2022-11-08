package ru.job4j.gc;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Benchmark;

@BenchmarkMode(Mode.All)
@Fork(value = 2)
@Warmup(iterations = 5)
@Measurement(iterations = 2)

public class ArticleTest {

    @Test
    @Benchmark
    public void whenLongTextFalse() {
        assertThat(
                Article.generateBy1(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "qqqqqqqwwwwwe eqw e qwe  wq g gb wgklio jm iomnrolr egwetghwrhyr hyje yj t j y  ey j"
                                + "yet jhetjetjw wqe q g ; m mk;'opjmiop mopjmiopji ohihioph "
                                + "iohiohqpiohjfih iohqjiohq[iohg [ioh hq[q[q[q[rjhe[gioi wgwegpqpogjrqoperjgpjq"
                                + "qjop[qrgopq qriojegopqergpqoergmqoprg "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь"
                ),
                is(false)
        );
    }

    @Test
    @Benchmark
    public void whenLongTextFalse2() {
        assertThat(
                Article.generateBy2(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "qqqqqqqwwwwwe eqw e qwe  wq g gb wgklio jm iomnrolr egwetghwrhyr hyje yj t j y  ey j"
                                + "yet jhetjetjw wqe q g ; m mk;'opjmiop mopjmiopji ohihioph "
                                + "iohiohqpiohjfih iohqjiohq[iohg [ioh hq[q[q[q[rjhe[gioi wgwegpqpogjrqoperjgpjq"
                                + "qjop[qrgopq qriojegopqergpqoergmqoprg "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь"
                ),
                is(false)
        );
    }

    @Test
    @Benchmark
    public void whenLongTextFalse3() {
        assertThat(
                Article.generateBy2(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "qqqqqqqwwwwwe eqw e qwe  wq g gb wgklio jm iomnrolr egwetghwrhyr hyje yj t j y  ey j"
                                + "yet jhetjetjw wqe q g ; m mk;'opjmiop mopjmiopji ohihioph "
                                + "iohiohqpiohjfih iohqjiohq[iohg [ioh hq[q[q[q[rjhe[gioi wgwegpqpogjrqoperjgpjq"
                                + "qjop[qrgopq qriojegopqergpqoergmqoprg "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь"
                ),
                is(false)
        );
    }

    @Test
    @Benchmark
    public void whenLongTextFalse4() {
        assertThat(
                Article.generateBy2(
                        "Мой дядя самых честных правил, "
                                + "Когда не в шутку занемог, "
                                + "Он уважать себя заставил "
                                + "И лучше выдумать не мог. "
                                + "Его пример другим наука; "
                                + "Но, боже мой, какая скука "
                                + "С больным сидеть и день и ночь, "
                                + "Не отходя ни шагу прочь! "
                                + "Какое низкое коварство "
                                + "Полуживого забавлять, "
                                + "Ему подушки поправлять, "
                                + "Печально подносить лекарство, "
                                + "Вздыхать и думать про себя: "
                                + "qqqqqqqwwwwwe eqw e qwe  wq g gb wgklio jm iomnrolr egwetghwrhyr hyje yj t j y  ey j"
                                + "yet jhetjetjw wqe q g ; m mk;'opjmiop mopjmiopji ohihioph "
                                + "iohiohqpiohjfih iohqjiohq[iohg [ioh hq[q[q[q[rjhe[gioi wgwegpqpogjrqoperjgpjq"
                                + "qjop[qrgopq qriojegopqergpqoergmqoprg "
                                + "Когда же черт возьмет тебя!",
                        "Мой дядя мог думать про Linux и Java день и ночь"
                ),
                is(false)
        );
    }

}