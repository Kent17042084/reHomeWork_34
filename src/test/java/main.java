public class main {
    public class ForTestClass_6_homework {
        @Test

    /*
    ДЗ 34. Переделать тест с последнего слайда презентации урока 29
    Тест должен собирать ссылки всех категории из сайдбара с главной страницы розетки и проверять,
    что урл возвращает 200 ответ, если нет фейлит тест с сообщением!
     */

        public void checkingResponse() throws IOException {
            open("https://rozetka.com.ua/");
            ElementsCollection sidebarMenu = $$(By.xpath("//a[@class='menu-categories__link']"));

            for (WebElement el : sidebarMenu) {
                String link = el.getAttribute("href");;
                checkingResp(link);
            }
        }

        public void checkingResp(String linksOnThePage) throws IOException {
            URL url = new URL(linksOnThePage);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            int responseCode = http.getResponseCode();
            System.out.println(responseCode + " " + linksOnThePage);
            if (responseCode != 200) {
                Assert.fail("The status code is not 200");
            }
        }
    }
}
