
# Imaginary TV Show Ending – Android App

## 📱 Project Overview
This Android application imitates the ending of an imaginary TV show (similar to a box-selection game).  
The app guides the user through **three pages**, where they select a box, see one box revealed, and finally view their prize.

The project demonstrates:
- Multi-screen navigation
- Shared UI state using **ViewModel**
- Custom UI theming
- Clean Android architecture using **Kotlin**

---

## 🧩 App Features

### ✅ Page 1 – Box Selection
- Displays **five closed boxes**
- User selects **one box**
- The **Next** button is disabled until a box is selected

### ✅ Page 2 – Box Reveal
- The app reveals **one box that was NOT selected**
- User can:
  - Keep their original box
  - Switch to another available box
- The revealed box cannot be selected

### ✅ Page 3 – Final Result
- Displays:
  - The prize from the selected box
  - The contents of **all boxes** below

### ℹ️ About Dialog
- Accessible using the **“?” button** in the top bar
- Displays app and assignment information

---

## 🧠 Architecture & Design

- **Language:** Kotlin  
- **Architecture:** MVVM  
- **State Management:** Shared `ViewModel`  
- **UI:** XML layouts  
- **Theme:** Customized colors, fonts, and spacing  
- **Navigation:** Activities with shared ViewModel  

---


## ▶️ How to Run the App

1. Open **Android Studio**
2. Click **Open** and select the project folder
3. Wait for **Gradle Sync** to finish
4. Run the app on:
   - Android Emulator (API 34 recommended)
   - Or a physical Android device

---

## 🎨 UI Customization
- Pleasant color palette
- Readable font sizes
- Buttons and layouts sized for usability
- Clean spacing and alignment

---

## 🧪 Tested On
- Android Emulator  
- API Level 34 (Android 14)

---

## 👩‍💻 Author
**Youstina Botros**  
Bachelor of Computer Science – Mobile Computing  
Sheridan College

---

## 📌 Notes
This project was developed as part of an academic assignment to practice:
- Android navigation
- ViewModel state sharing
- UI/UX design
- Clean Kotlin code structure
