package ru.job4j.ODD.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void deleteSession() {
        Cinema cinema = new Cinema3D();
        String sessionOld = "";
        cinema.removeIf(sessionOld);
        assertThat(null, is(cinema.get(sessionOld)));
    }

    @Test
    public void registration() {
        Cinema cinema = new Cinema3D();
        Account account = new Account(
                name,
                login,
                dateOfBith,
                city,
                payment(googleAcc)
        );
        assertNotNull(account);
    }

    @Test
    public void registrationRef() {
        Cinema cinema = new Cinema3D();
        Account account = new Account(
                reference(facebook()),
                payment(payPal)
        );
        assertNotNull(account);
    }

    @Test
    public void map() {
        Map map = new Map();
        Cinema cinema = new Cinema3D();
        Map mapOnSite = checkMap();
        assertThat(map, is(mapOnSite));
    }

    @Test
    public void priceFood() {
        Cinema cinema = new Cinema();
        Page foodList = new Food(
                new Combos(ofMonth(sysdate)),
                new Sales(ofWeek(sysdate)),
                new commonFood()
        );
        assertThat(foodList.get(combos), is(listOfCombos(sysdate)));
        assertThat(foodList.get(sales), is(listOfSales(sysdate)));
        assertThat(foodList.get(common), is(listOfCommonFoods(sysdate)));
    }
}