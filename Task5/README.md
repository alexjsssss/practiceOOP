# Лабораторна робота №5  
**Тема:** Реалізація шаблонів Command, MacroCommand, Singleton. Скасування операцій (Undo).  

---

## 🎯 Мета роботи
1. Реалізувати можливість **скасування (undo)** виконаних операцій.  
2. Продемонструвати поняття **«макрокоманда»** — об’єднання кількох команд у єдину структуру.  
3. Використати шаблон проектування **Singleton** для керування екземпляром програми.  
4. Забезпечити **діалоговий інтерфейс** із користувачем.  
5. Розробити клас для **тестування функціональності** програми.  

---

## 📂 Структура проекту
<img width="248" height="666" alt="image" src="https://github.com/user-attachments/assets/9c65adfc-3587-49b5-9f28-7940a933f646" />

---

## ⚙️ Опис класів
- **Main** – точка входу; створює екземпляр `Application` (Singleton) і запускає програму.  
- **Application** – головний клас, що формує меню команд; реалізує шаблон **Singleton**.  
- **Command** – базовий інтерфейс команди з методом `execute()`.  
- **ConsoleCommand** – інтерфейс для консольних команд із методом `getKey()`.  
- **Menu** – реалізує **макрокоманду**; містить колекцію команд і стек історії для undo.  
- **ChangeItemCommand** – змінює параметри об’єкта `Item2d`.  
- **ChangeConsoleCommand** – консольна команда для зміни даних; викликає `ChangeItemCommand`.  
- **GenerateConsoleCommand** – генерує випадкові дані.  
- **SaveConsoleCommand** – серіалізує поточний стан колекції.  
- **RestoreConsoleCommand** – десеріалізує останній збережений стан.  
- **ViewConsoleCommand** – відображає поточні результати у вигляді таблиці.  
- **UndoConsoleCommand** – реалізує **скасування останньої команди** (undo).  
- **MainTest** – просте тестування роботи команд без JUnit.  

---

## 🖥️ Приклад роботи програми

### 1. Генерація даних (`'g'enerate`)
<img width="482" height="188" alt="image" src="https://github.com/user-attachments/assets/3c73999a-4774-4eb3-a408-5bcbcd423429" />

### 2. Зміна даних (`'c'hange`)
<img width="475" height="189" alt="image" src="https://github.com/user-attachments/assets/2b5bf9bf-00be-4812-94df-c4b76a91e283" />

### 3. Збереження (`'s'ave`)
<img width="485" height="189" alt="image" src="https://github.com/user-attachments/assets/b8bf43b1-199e-43c4-9ef4-8c3611cd0b03" />

### 4. Відновлення (`'r'estore`)
<img width="472" height="181" alt="image" src="https://github.com/user-attachments/assets/175faa72-e253-45ff-b359-1df0eb1009a9" />

### 5. Скасування (`'u'ndo`)
<img width="477" height="54" alt="image" src="https://github.com/user-attachments/assets/b1f71409-ed35-4b00-a741-fd1af90569ab" />

### 6. Перегляд (`'v'iew`)
<img width="483" height="189" alt="image" src="https://github.com/user-attachments/assets/71025ac4-8ff7-473f-a20e-5ff5bd289b55" />

### 7. Вихід (`'q'uit`)
<img width="490" height="51" alt="image" src="https://github.com/user-attachments/assets/abc10993-da58-4f43-8052-445a4a93aac4" />

---

## ✅ Висновки
- Реалізовано шаблони **Command**, **MacroCommand** та **Singleton**.  
- Додано можливість **скасування (undo)** останньої виконаної команди.  
- Меню виступає як **макрокоманда**, що об’єднує всі дії користувача.  
- Забезпечено **діалоговий інтерфейс** із командами `'v'`, `'g'`, `'c'`, `'s'`, `'r'`, `'u'`, `'q'`.  
- Програма коректно генерує, змінює, зберігає, відновлює та скасовує операції.  

