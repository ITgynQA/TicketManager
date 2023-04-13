import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Самара", 3000, 10, 12);
    Ticket ticket2 = new Ticket("Москва", "Архангельск", 1000, 10, 12);
    Ticket ticket3 = new Ticket("Москва", "Самара", 2000, 10, 14);
    Ticket ticket4 = new Ticket("Москва", "Самара", 4000, 10, 18);
    Ticket ticket5 = new Ticket("Москва", "Самара", 5000, 10, 11);
    Ticket ticket6 = new Ticket("Москва", "Самара", 1000, 10, 12);

    @Test
    public void searchT1LessT2() {
        assertEquals(-1, ticket6.compareTo(ticket5));
    }

    @Test
    public void searchT1MoreT2() {
        assertEquals(1, ticket4.compareTo(ticket2));
    }

    @Test
    public void searchT1EqualsT2() {
        assertEquals(0, ticket2.compareTo(ticket6));
    }

    @Test
    public void searchAllTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);


        Assertions.assertArrayEquals(new Ticket[]{ticket6, ticket3, ticket1, ticket4, ticket5}, aviaSouls.search("Москва", "Самара"));
    }

    @Test
    public void searchOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{ticket6}, aviaSouls.search("Москва", "Самара"));
    }

    @Test
    public void searchTwoTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket2);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{ticket6}, aviaSouls.search("Москва", "Самара"));
    }

    @Test
    public void searchUnsuitableTicket() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket2);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.search("Москва", "Самара"));
    }

    @Test
    public void searchUnsuitableTicketOnTo() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.search("Москва", "Тверь"));
    }

    @Test
    public void searchUnsuitableTicketOnFrom() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.search("Самара", "Архангельск"));
    }

    @Test
    public void searchUnsuitableTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.search("Хабаровск", "Тверь"));
    }

    @Test
    public void compareT1LessT2() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        assertEquals(-1, timeComparator.compare(ticket5, ticket2));
    }

    @Test
    public void compareT1EqualsT2() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        assertEquals(0, timeComparator.compare(ticket2, ticket6));
    }

    @Test
    public void compareT1MoreT2() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        assertEquals(1, timeComparator.compare(ticket3, ticket5));
    }

    @Test
    public void compareAllTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{ticket5, ticket1, ticket6, ticket3, ticket4}, aviaSouls.searchAndSortBy("Москва", "Самара", timeComparator));
    }

    @Test
    public void compareUnsuitableTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket2);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.searchAndSortBy("Москва", "Самара", timeComparator));
    }

    @Test
    public void compareOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{ticket5}, aviaSouls.searchAndSortBy("Москва", "Самара", timeComparator));
    }

    @Test
    public void compareTwoTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket2);
        aviaSouls.add(ticket5);

        Assertions.assertArrayEquals(new Ticket[]{ticket5}, aviaSouls.searchAndSortBy("Москва", "Самара", timeComparator));
    }

    @Test
    public void compareUnsuitableTicketOnTo() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.searchAndSortBy("Москва", "Тверь", timeComparator));
    }

    @Test
    public void compareUnsuitableTicketOnFrom() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.searchAndSortBy("Самара", "Архангельск", timeComparator));
    }

    @Test
    public void compareUnsuitableTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.searchAndSortBy("Хабаровск", "Тверь", timeComparator));
    }

}