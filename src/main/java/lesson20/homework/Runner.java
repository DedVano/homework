package lesson20.homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lesson20.homework.serviceClasses.Department;
import lesson20.homework.serviceClasses.Employee;
import lesson20.homework.serviceClasses.EmployeeWrapper;
import lesson20.homework.serviceClasses.Position;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

    private static final TypeReference<EmployeeWrapper> TR = new TypeReference<>() {
    };

    public static void main(String[] args) {
        String filepath = "src/main/resources/";
        String fileNameXML = "employees.xml";
        String fileNameJSON = "employees.json";
        Path fileFullNameXML = Paths.get(filepath, fileNameXML);
        Path fileFullNameJSON = Paths.get(filepath, fileNameJSON);
        EmployeeWrapper employeeWrapper = new EmployeeWrapper(new ArrayList<>());
        List<Employee> employees = employeeWrapper.getEmployees();

        Department salesDepartment = new Department("Отдел продаж", "Москва");
        Department itDepartment = new Department("Отдел ИТ", "Москва");
        Department cleaningDepartment = new Department("Служба клининга", "Москва");

        Position salesDirector = new Position("Руководитель отдела продаж", new BigDecimal(270000));
        Position viceSalesDirector = new Position("Заместитель руководителя отдела продаж", new BigDecimal(130000));
        Position salesManager = new Position("Менеджер отдела продаж", new BigDecimal(90000));
        Position itDirector = new Position("Руководитель отдела ИТ", new BigDecimal(150000));
        Position programmer = new Position("Программист", new BigDecimal(115000));
        Position administratorIT = new Position("Системный администратор", new BigDecimal(80000));
        Position cleaningManager = new Position("Уборщик", new BigDecimal(50000));

        employees.add(new Employee("5b-4524", "veselov", "Веселов Максим Павлович", salesDepartment, salesDirector));
        employees.add(new Employee("5b-4528", "kiselev", "Киселев Никита Тимофеевич", salesDepartment, viceSalesDirector));
        employees.add(new Employee("5b-4532", "melnikov", "Мельников Павел Дмитриевич", salesDepartment, salesManager));
        employees.add(new Employee("5b-4533", "tretyakov", "Третьяков Максим Ярославович", salesDepartment, salesManager));
        employees.add(new Employee("5b-4538", "klimov", "Климов Николай Владимирович", salesDepartment, salesManager));
        employees.add(new Employee("5b-4540", "avdeev", "Авдеев Роберт Васильевич", salesDepartment, salesManager));
        employees.add(new Employee("7d-2132", "zhukov", "Жуков Арсений Елисеевич", itDepartment, itDirector));
        employees.add(new Employee("7d-2143", "rogov", "Рогов Максим Даниилович", itDepartment, administratorIT));
        employees.add(new Employee("7d-2147", "chernov", "Чернов Эмиль Вадимович", itDepartment, programmer));
        employees.add(new Employee("7d-2149", "lobanov", "Лобанов Демид Давидович", itDepartment, programmer));
        employees.add(new Employee("2v-1290", "korotkov", "Коротков Тимофей Артурович", cleaningDepartment, cleaningManager));

        System.out.println("Выгружаем базу сотрудников в документ XML.");
        if (!writeToXML(employeeWrapper, fileFullNameXML)) {
            return;
        }
        System.out.println("Поищем в XML документе сотрудников с окладом выше среднего.");
        findBigSalary(fileFullNameXML);

        System.out.println("Теперь преобразуем файл XML в формат JSON.");
        convertXML2JSON(fileFullNameXML, fileFullNameJSON);

        System.out.println("Найдем из JSON файла нечетных сотрудниковю");
        findFromJSON(fileFullNameJSON);
    }

    private static boolean writeToXML(EmployeeWrapper employeeWrapper, Path xmlFile) {
        try (FileWriter xmlFileName = new FileWriter(xmlFile.toFile())) {
            JAXBContext context = JAXBContext.newInstance(EmployeeWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employeeWrapper, xmlFileName);
        } catch (IOException e) {
            System.out.println("При выгрузке базы сотрудников в XML произошла ошибка записи в файл");
            System.out.println(e.getMessage());
            return false;
        } catch (JAXBException e) {
            System.out.println("При выгрузке базы сотрудников в XML произошла ошибка формата данных.");
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void findBigSalary(Path xmlFile) {
        try (InputStream inputStream = Files.newInputStream(xmlFile)) {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(inputStream);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "sum(//Employee/position/salary) div count(//Employee/position/salary)";
            double avg = (Double) xPath
                    .compile(expression)
                    .evaluate(xmlDocument, XPathConstants.NUMBER);
            System.out.printf("Среднее значение окладов среди всех сотрудников: %.2f\n", avg);
            System.out.println("Найденные сотрудники:");
            expression = "//Employee[position/salary>" + avg + "]";
            NodeList bigSalaryEmployees = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            if (bigSalaryEmployees.getLength() == 0) {
                System.out.println("Никого не нашли, видимо, у всех одинаковая зарплата.");
                return;
            }
            for (int i = 0; i < bigSalaryEmployees.getLength(); i++) {
                Node node = bigSalaryEmployees.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.printf("Сотрудник: %s\n", element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.printf("\tId: %s\n", element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.printf("\tЛогин: %s\n", element.getElementsByTagName("login").item(0).getTextContent());
                    System.out.printf("\tОтдел:\n\t\tНазвание: %s\n", element.getElementsByTagName("departmentName").item(0).getTextContent());
                    System.out.printf("\t\tГород: %s\n", element.getElementsByTagName("city").item(0).getTextContent());
                    System.out.printf("\tДолжность:\n\t\tНазвание: %s\n", element.getElementsByTagName("positionName").item(0).getTextContent());
                    System.out.printf("\t\tОклад: %s\n", element.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
        } catch (IOException e) {
            System.out.println("При обращении к XML файлу возникла ошибка ввода-вывода");
        } catch (XPathExpressionException e) {
            System.out.println("Произошла ошибка при создании поискового запроса, что-то наши программисты напутали...");
        } catch (ParserConfigurationException e) {
            System.out.println("Извините, произошла какая-то ошибка в настройках XML парсера.");
        } catch (SAXException e) {
            System.out.println("Ошибка XML парсера: " + e.getMessage());
        }
    }

    private static void convertXML2JSON(Path fileNameXML, Path fileNameJSON) {
        try (FileWriter writer = new FileWriter(fileNameJSON.toFile()); Reader reader = new FileReader(fileNameXML.toFile())) {
            writer.write(XML.toJSONObject(reader).toString(4));
        } catch (IOException e) {
            System.out.println("При обращении к файлу возникла ошибка ввода-вывода");
        }
    }

    private static void findFromJSON(Path fileNameJSON) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        try {
            EmployeeWrapper employeeList = objectMapper.readValue(fileNameJSON.toFile(), TR);
            List<Employee> oddEmployees = employeeList.getEmployees().stream()
                    .filter(employee -> employeeList.getEmployees().indexOf(employee) % 2 == 1).collect(Collectors.toList());
            System.out.println(oddEmployees);
        } catch (IOException e) {
            System.out.println("При обращении к файлу возникла ошибка ввода-вывода");
        }
    }
}
