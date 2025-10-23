# 📄 Jasper Report API (Spring Boot + JasperReports)

This project demonstrates a **basic implementation of JasperReports** integrated with **Spring Boot**, providing a simple REST API to **generate and return PDF reports** dynamically.

---

## 🚀 Features

- 📦 JasperReports integration with Spring Boot  
- 🧾 API endpoint to generate PDF reports  
- 🧰 Configurable report templates (`.jrxml` files)  
- ⚙️ Dynamic data filling for report generation  
- 💡 Easy to extend for custom report requirements  

---

## 🧠 Project Overview

This project serves as a **starter template** for integrating JasperReports in Java-based applications.  
It can be extended for use cases like:
- Billing or invoice generation  
- Patient or employee reports  
- Statistical summaries  
- Any server-side PDF generation use case  

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|-------------|
| Backend Framework | Spring Boot |
| Reporting Engine | JasperReports |
| Language | Java |
| Build Tool | Maven / Gradle |
| Output Format | PDF |

---

## ⚙️ How It Works

1. A `.jrxml` report template is compiled into a `.jasper` file.  
2. Data (from static or dynamic sources) is filled into the report.  
3. JasperReports engine exports the filled report to a PDF file.  
4. The API returns the generated PDF in the HTTP response.

---

## 🧾 Example Output

The API generates a PDF (e.g., **`sample_report.pdf`**) containing formatted data like:
- Title and header section  
- Tabular data  
- Footer or summary  

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

> 🛠️ *A simple and extensible starting point for building JasperReports-powered PDF generation APIs in Spring Boot.*
