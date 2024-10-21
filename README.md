# <u>Тестовое задание</u>

## <u>1 часть: SOAP сервис "Решение квадратного уравнения"</u>

Разработать SOAP сервис на стеке Java EE, который решает квадратное уравнение вида A * X^2 + B * X + C = 0 с использованием дискриминанта. Запрос должен быть выполнен в формате XML:

&lt;request&gt;&lt;a&gt;3&lt;/a&gt;&lt;b&gt;4&lt;/b&gt;&lt;c&gt;1&lt;/c&gt;&lt;/request&gt;

Сервис должен возвращать ответ в формате XML:

&lt;response&gt;&lt;formula&gt;3x^2+4x+1=0&lt;/formula&gt;&lt;D&gt;0&lt;/D&gt;&lt;x1&gt;0&lt;/x1&gt;&lt;x2&gt;0&lt;/x2&gt;&lt;/response&gt;

В случае, если дискриминант меньше нуля, должно быть создано исключение. 

Элементы a, b, c в запросе являются обязательными. 

Элемент x2 может отсутствовать, если дискриминант равен 0. 

Ответ с ошибкой должен содержать элементы formula, D и сообщение об ошибке. 

У сервиса должно автоматически генерироваться описание в формате WSDL с XSD-схемами.


## <u>2 часть: Веб-сервис на стеке Spring Boot</u>

Разработать веб-сервис на основе Spring Boot, который обращается к первому SOAP-сервису для получения решения квадратного уравнения. 

Веб-сервис должен принимать запросы по следующему URL: http://localhost:port/api/calc/?a=3&b=4&c=1

Ответ на запрос должен быть в формате JSON:

{ "formula": "3.0x^2 + 4.0x + 1.0 = 0", "D": 0, "x1": 0, "x2": 0 }


## <u>Требования к проектам</u>

Два независимых проекта: один для SOAP сервиса, другой для Spring Boot веб-сервиса. 

Сборка проектов с использованием Maven или Gradle. Java 8+. 

Сервер приложений: WildFly, Tomcat или другой. Инструкция по сборке и запуску приложений. 

Плюсом будет наличие тестов, а также использование Docker и Docker Compose.

## <u>Инструкция по сборке и запуску</u>

SOAP Сервис: Клонировать проект и перейти в каталог. Сборка проекта с использованием Maven. Запустить сервер приложений и развернуть SOAP сервис. Убедиться, что ваш SOAP сервис доступен по WSDL-URL.

Spring Boot Веб-сервис: Клонировать проект и перейти в каталог. Сборка проекта с использованием Maven. Запустить Spring Boot приложение. Проверить работу веб-сервиса, отправив GET-запрос на указанный URL.


# <u>СЕРВЕРЫ</u>

**QuadraticEquationService**

**Описание:** QuadraticEquationService — это веб-сервис на основе Jakarta EE, предназначенный для решения квадратных уравнений. 

Он предо-ставляет SOAP API, с помощью которого можно передавать коэффици-енты уравнения (a, b, c) и получать его решения (корни).

Проект разворачивается в контейнере сервлетов, таком как Apache Tomcat, и предлагает интерфейс для тестирования через инструменты, такие как SOAPUI или Postman.
 
**Структура проекта**

1.	QuadraticEquationService (интерфейс):
   
o	Определяет метод solveQuadraticEquation, который прини-мает коэффициенты уравнения (a, b, c) и возвращает объект SolveResponse.

o	Метод аннотирован как @WebMethod, что позволяет сде-лать его доступным через SOAP.

2.	QuadraticEquationServiceImpl (класс):
   
o	Реализует интерфейс QuadraticEquationService и содержит логику решения квадратного уравнения.

o	Вычисляет дискриминант и в зависимости от его значения возвращает одно или два решения, либо бросает исключение DiscriminantException, если дискриминант отрицательный.

3.	DiscriminantException (класс):
   
o	Кастомное исключение, которое выбрасывается, если дис-криминант отрицательный и уравнение не имеет действи-тельных корней.

o	Содержит информацию об ошибке и объект SolveResponse.

4.	SolveResponse (класс):
   
o	Используется для представления ответа сервиса.

o	Содержит поля для формулы уравнения, значения дискри-минанта (D) и двух возможных корней (x1 и x2).

5.	QuadraticEquationServicePublisher (класс):
    
o	Предназначен для локального запуска сервиса без использо-вания сервлета.

o	Запускает веб-сервис по указанному URL (например, http://localhost:8080/QuadraticEquationService).

6.	QuadraticEquationServiceServlet (класс):
    
o	Реализует HttpServlet и используется для развертывания сервиса в контейнере сервлетов, таком как Tomcat.

o	Инициализирует и публикует веб-сервис при запуске при-ложения и завершает его при остановке.

7.	web.xml:
    
o	Конфигурационный файл для развертывания в Tomcat, указывающий, какой сервлет использовать для обработки за-просов на определенном URL (/QuadraticEquationService/*).

8.	pom.xml:
    
o	Файл Maven, содержащий информацию о зависимостях, не-обходимых для работы с Jakarta EE, JAX-WS и другими библиотеками, а также настройки компиляции.
 
**Шаги по развертыванию и запуску проекта через Tomcat**

1.	Создание проекта:
   
o	Создайте Maven-проект с именем QuadraticEquation.

o	Разместите все классы в пакете org.example.

o	Скопируйте и вставьте соответствующий код в классы.

o	Добавьте файл pom.xml с необходимыми зависимостями.

2.	Сборка проекта:
   
o	Выполните команду Maven для сборки проекта:

mvn clean install

Это создаст .war файл, который можно будет развернуть в Tomcat.

3.	Развертывание в Tomcat:
   
•	Скопируйте сгенерированный .war файл (QuadraticEquation.war) в папку webapps Tomcat.

•	Запустите Tomcat через bin/startup.sh (для Unix) или bin/startup.bat (для Windows).

•	Tomcat автоматически развернет .war файл, и сервис будет досту-пен по адресу:

•	http://localhost:8083/QuadraticEquationService/QuadraticEquationService

Если всё прошло успешно, откроется страница с информацией о развернутом веб-сервисе.

 
**Тестирование с помощью Postman или SoapUI**

1.	Тестирование с использованием SoapUI:
   
o	Создайте новый SOAP-проект в SoapUI.

o	Введите URL WSDL для вашего сервиса:

http://localhost:8083/QuadraticEquationService/QuadraticEquationService?wsdl

SoapUI автоматически загрузит описание сервиса.

•	Вызовите метод solveQuadraticEquation и передайте значения для параметров a, b, и c.

•	Просмотрите ответ и убедитесь, что сервис возвращает коррект-ные значения для дискриминанта и корней.

2.	Тестирование с использованием Postman:
   
•	Postman больше подходит для REST-запросов, но его можно ис-пользовать и для SOAP-запросов через отправку "сырых" запро-сов.

•	Создайте новый запрос, выберите тип POST, и укажите URL:

http://localhost:8083/QuadraticEquationService/QuadraticEquationService

•  Перейдите на вкладку Body, выберите "raw" и установите тип XML.

•  Вставьте SOAP-запрос:

&lt;soapenv:Envelope xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;

                 xmlns:org=&quot;http://example.org/&quot;&gt;
                 
   &lt;soapenv:Header/&gt;
   
   &lt;soapenv:Body&gt;
   
      &lt;org:solveQuadraticEquation&gt;
      
         &lt;org:a&gt;1&lt;/org:a&gt;
         
         &lt;org:b&gt;-3&lt;/org:b&gt;
         
         &lt;org:c&gt;2&lt;/org:c&gt;
         
      &lt;/org:solveQuadraticEquation&gt;
      
   &lt;/soapenv:Body&gt;
   
&lt;/soapenv:Envelope&gt;


Нажмите "Send" и проверьте ответ сервиса:

<?xml version='1.0' encoding='UTF-8'?>

<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">

    <S:Body>
    
        <ns2:solveQuadraticEquationResponse xmlns:ns2="http://example.org/">
        
            <return>
            
                <d>1.0</d>
                
                <formula>1.0x^2 + -3.0x + 2.0 = 0</formula>
                
                <x1>2.0</x1>
                
                <x2>1.0</x2>
                
            </return>
            
        </ns2:solveQuadraticEquationResponse>
        
    </S:Body>
    
</S:Envelope>
