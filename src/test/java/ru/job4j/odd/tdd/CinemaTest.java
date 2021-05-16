package ru.job4j.odd.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

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
    @Test(expected = CantBuyTicket("Место уже куплено").class)
    public void buy2() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account1, 1, 1, date);
        Ticket ticket = cinema.buy(account2, 1, 1, date);
    }

    @Test(expected = CantBuyTicket("Место забронировано").class)
    public void buy3() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.book(account1, 1, 1, date);
        Ticket ticket = cinema.buy(account2, 1, 1, date);
    }

    @Test(expected = CantBuyTicket("Место забронировано").class)
    public void buy4() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.book(account1, 1, 1, date);
        Ticket ticket = cinema.buy(account2, 1, 1, date);
    }

    @Test(expected = CantBuyTicket("Место уже забронировано. Выберите другое место.").class)
    public void buy5() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.book(account1, 1, 1, date);
        Ticket ticket = cinema.book(account2, 1, 1, date);
    }

    @Test(expected = CantBuyTicket("Не удалось приобрести билет на указанную дату").class)
    public void buy5() {
        Account account1 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 32, 23, 00);
        Ticket ticket = cinema.buy(account1, 1, 1, date);
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

    @Test(expected = CantRegistr("Данный аккаунт уже зарегестрирован").class)
    public void registration2() {
        Cinema cinema = new Cinema3D();
        Account account = new Account(
                name,
                login,
                dateOfBith,
                city,
                payment(googleAcc)
        );
        Account account = new Account(
                name,
                login,
                dateOfBith,
                city,
                payment(googleAcc)
        );
    }

    @Test(expected = CantRegistr("В поле \"дата рождения\" введены некорректные данные").class)
    public void registration2() {
        Cinema cinema = new Cinema3D();
        Account account = new Account(
                name,
                login,
                login,
                city,
                payment(googleAcc)
        );
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
    }   */
}