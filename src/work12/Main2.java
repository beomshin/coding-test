package work12;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        List<Pizza> list = new ArrayList<Pizza>();
        list.add(new Pizza("margherita", 7, 8, 10));
        list.add(new Pizza("hawaii", 8, 9, 12));
        list.add(new Pizza("capricciosa", 5, 7, 13));

        Pizza[] pizzas = list.toArray(new Pizza[list.size()]);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("margherita", "Small", 3));
        orderItems.add(new OrderItem("capricciosa", "Large", 2));
        orderItems.add(new OrderItem("hawaii", "Large", 3));
        orderItems.add(new OrderItem("margherita", "Large", 1));
        orderItems.add(new OrderItem("hawaii", "Medium", 1));
        orderItems.add(new OrderItem("capricciosa", "Small", 5));
        orderItems.add(new OrderItem("capricciosa", "Medium", 1));

        OrderItem[] orderItems1 = orderItems.toArray(new OrderItem[orderItems.size()]);

        int count = solution(pizzas, orderItems1);

        System.out.println(count);
    }

    static class Pizza {
        public String name; // 피자 이름
        public int price_S; // 소형 가격
        public int price_M; // 중형 가격
        public int price_L; // 대형 가격

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }
    }

    static class OrderItem {
        public String name; // 주문 피자의 이름
        public String size; // 주문하려는 피자 사이즈 ( 소 중 대)
        public int quantity; // 주문 수량

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }
    }

    private static HashMap<String, Pizza> menuPan = new HashMap();

    public static int solution(Pizza[] menu, OrderItem[] order) {
        // Implement your solution here
        int answer = Integer.MAX_VALUE;
        for (Pizza p : menu) {
            menuPan.put(p.name, p);
        }

        int noSalePrice = notSale(order);
        int firstSalePrice = firstSale(order, noSalePrice);
        int secondSalePrice = secondSale(order, noSalePrice);
        int thirdSale = thirdSale(order, noSalePrice);
        int fourthSale = fourthSale(order, noSalePrice);

        answer = Math.min(answer, noSalePrice);
        answer = Math.min(answer, firstSalePrice);
        answer = Math.min(answer, secondSalePrice);
        answer = Math.min(answer, thirdSale);
        answer = Math.min(answer, fourthSale);

        return answer;
    }

    public static int notSale(OrderItem[] order) { // 세일을 하지 않은 경우
        int cost = 0;
        for (OrderItem o : order) {
            Pizza p = menuPan.get(o.name); // 주문에 있는 모든 이름은 메뉴에 있음
            cost += getPrice(o.size, p) * o.quantity;
        }
        return cost;
    }

    public static  int firstSale(OrderItem[] order, int noSalePrice) { // 3개이상 구매시 작은 사이즈 cost 무료
        int cost = noSalePrice;
        int count = 0;
        for (OrderItem o : order) {
            count += o.quantity;
        }

        if (count >= 3) {
            int min = Integer.MAX_VALUE;
            for (OrderItem o : order) {
                Pizza p = menuPan.get(o.name); // 주문에 있는 모든 이름은 메뉴에 있음
                min = Math.min(min, getPrice(o.size, p));
            }
            cost -= min; // 3개 이상 경우 최소 금액 피자 할인
        }

        return cost;
    }

    public static  int secondSale(OrderItem[] order, int noSalePrice) { // 같은 피자 5개 구매시 100원 처리
        int cost = noSalePrice;

        HashMap<String, Integer> orderMap = new HashMap();
        for (OrderItem o : order) {
            orderMap.put(o.name, orderMap.getOrDefault(o.name, 0) + o.quantity); // 피자 주문 수량 넣기
        }

        Iterator<String> it = orderMap.keySet().iterator();

        while (it.hasNext()) {
            String pizzaName = it.next();
            int count = orderMap.get(pizzaName); // 주문 수량

            if (count >= 5) {

                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 크기에 따라 가격에 최소 보장 못하여 우선 순위 큐사용 (큰값부터 빼야 최대할인률)

                for (OrderItem o : order) {
                    if (pizzaName.equals(o.name)) { // 피자이름이 같은경우

                        for (int i=0; i < o.quantity; i++) { // 수량만큼 금액 입력
                            priorityQueue.add(getPrice(o.size, menuPan.get(pizzaName)));
                        }

                    }
                }

                int minus = 0; // 5개 할인 금액 구하기
                for (int i=0; i < 5; i++) {
                    minus += priorityQueue.poll();
                }

                cost = Math.min(cost, noSalePrice - minus + 100); // 같은 피자가 5개이상 피자가 여러개일수있어 계산 최소값 구하기
            }
        }


        return cost;
    }

    public static  int thirdSale(OrderItem[] order, int noSalePrice) { // 같은 이름의 대형 피자 주문시 소형피자 무료
        int cost = noSalePrice;
        HashMap<String, Integer> orderMap = new HashMap();
        for (OrderItem o : order) {
            if (o.size.equals("Small")) { // 소량 경우
                orderMap.put(o.name, orderMap.getOrDefault(o.name, 0) + o.quantity); // 소량경우 피자명 / 수량
            }
        }

        for (OrderItem o : order) {
            if (o.size.equals("Large") && orderMap.containsKey(o.name)) { // 주문 수량이 대량이면서 해당 피자 소량이 있는 경우
                int largeCount = o.quantity; // 대량 주문 수량
                int smallCount = orderMap.get(o.name); // 소량 주문 수량

                if (largeCount >= smallCount) {
                    cost -= getPrice("Small", menuPan.get(o.name)) * smallCount; // 소량 개수만큼 빼기
                } else {
                    cost -= getPrice("Small", menuPan.get(o.name)) * largeCount; // 대량 개수만큼 빼기
                }
            }
        }

        return cost;
    }

    public static  int fourthSale(OrderItem[] order, int noSalePrice) { // 대형 사이즈 3개 이상시 같은 이름의 3개 중형 피자 가격
        int cost = noSalePrice;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (OrderItem o : order) {
            if (o.size.equals("Large")) { // 대형 피자인경우
                for (int i=0; i < o.quantity; i++) { // 수량만큼
                    int minus = getPrice("Large", menuPan.get(o.name)) - getPrice("Medium", menuPan.get(o.name)); // 대형 - 중형 차액 넣기
                    priorityQueue.add(minus); // 중형 가격 기입
                }
            }
        }

        if (!priorityQueue.isEmpty() && priorityQueue.size() >= 3) {
            for (int i=0; i <3; i++) {
                cost -= priorityQueue.poll();
            }
        }

        return cost;
    }

    public static int getPrice(String size, Pizza pizza) {
        if (size.equals("Small")) {
            return pizza.price_S;
        } else if (size.equals("Medium")) {
            return pizza.price_M;
        } else if (size.equals("Large")) {
            return pizza.price_L;
        } else {
            throw new RuntimeException("Invalid size"); // 사이즈는 오직 3개로 해당 경우는 없음
        }
    }
}
