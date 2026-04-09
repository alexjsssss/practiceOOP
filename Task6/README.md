# Лабораторна робота №6  
**Тема:** Паралельна обробка даних та шаблон Worker Thread  

---

## 🎯 Мета роботи
- Продемонструвати можливість **паралельної обробки елементів колекції**:
  - пошук мінімуму та максимуму  
  - обчислення середнього значення  
  - комбіновані обчислення (MinMax)  
- Реалізувати управління чергою завдань за допомогою шаблону **Worker Thread**  

---

## ⚙️ Структура проекту
<img width="247" height="814" alt="image" src="https://github.com/user-attachments/assets/2406d38c-5583-4274-a003-8b07f0f53fa7" />

---

## 🖥️ Приклад роботи програми

### Генерація даних (`g`)
<img width="420" height="198" alt="image" src="https://github.com/user-attachments/assets/4f3969bb-b2c6-4a05-abee-a9be4a1b4e99" />

### Перегляд (`v`)
<img width="437" height="196" alt="image" src="https://github.com/user-attachments/assets/90acb691-6bb6-4a60-aaac-ed57c36ad956" />

### Зміна (`c`)
<img width="425" height="197" alt="image" src="https://github.com/user-attachments/assets/651b015f-2dc5-4780-bb77-3c6918d623ee" />

### Паралельне виконання (`e`)
<img width="599" height="357" alt="image" src="https://github.com/user-attachments/assets/0cecf8ca-2cf0-47a7-bda4-4d373d7c7b9f" />

### Вихід (`q`)
<img width="363" height="51" alt="image" src="https://github.com/user-attachments/assets/efe1002e-c3a0-4617-9fc1-d10085a06412" />

---

## ✅ Висновки
- Реалізовано паралельну обробку колекції за допомогою окремих команд (**AvgCommand**, **MaxCommand**, **MinMaxCommand**).  
- Використано шаблон **Worker Thread** для управління чергою завдань.  
- Кожна команда виконується у власному потоці, що дозволяє одночасно обчислювати різні характеристики колекції.  
- Програма підтверджує коректність роботи через повідомлення про прогрес та результати обчислень.  
