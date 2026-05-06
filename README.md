# AURA — Behavioral Stress Analyzer

[![GitHub Pages](https://img.shields.io/badge/Live%20Demo-GitHub%20Pages-blue?logo=github)](https://dilrag03.github.io/Aura-Stress-Analyzer/)

> A biometric behavioral stress analysis engine that uses typing patterns to estimate your current cognitive stress level.

---

## 🧠 How It Works

AURA analyzes three biometric signals from your typing behavior:

| Signal | Description |
|--------|-------------|
| **Typing Speed (WPM)** | Words per minute — fast + inaccurate = stress |
| **Error Count** | Character-level mismatch between target and input |
| **Time Taken** | Total time to complete the task |

These are combined into a **Stress Score (0–100%)** which maps to one of four states:

| State | Score | Meaning |
|-------|-------|---------|
| 🟢 **ZEN** | < 30 | Optimal cognitive performance |
| 🔵 **BALANCED** | 30–54 | Healthy alertness, slight fatigue |
| 🟡 **AGITATED** | 55–79 | Neural stress signals detected |
| 🔴 **BURNOUT** | ≥ 80 | Critical cognitive overload |

---

## 🗂️ Project Structure

```
Aura-Stress-Analyzer/
├── index.html      ← Web app (main entry point for GitHub Pages)
├── style.css       ← Dark-themed stylesheet with CSS variables
├── Aura.java       ← Java console version of the analyzer
└── README.md       ← This file
```

---

## 🌐 Web App (index.html + style.css)

The web app runs entirely in the browser — no backend required.

**Features:**
- Real-time typing timer
- Animated stress score ring
- Color-coded result states
- Personalized recovery recommendations
- Fully responsive design (mobile-friendly)

**To run locally:** Just open `index.html` in any modern browser.

**GitHub Pages:** Push to the `main` branch and enable Pages at `Settings → Pages → Branch: main`.

---

## ☕ Java Console App (Aura.java)

The Java version runs in the terminal and performs the same analysis.

**Requirements:** Java 8 or higher (JDK)

```bash
# Compile
javac Aura.java

# Run
java Aura
```

**Sample Output:**
```
╔══════════════════════════════════════════╗
║   AURA — Behavioral Stress Analyzer      ║
╚══════════════════════════════════════════╝

TARGET: "Peace begins with a relaxed mind and a steady breath."

Press ENTER when you are ready to start typing...
START TYPING: Peace begins with a relaxed mind and a steady breath.

╔══════════════════════════════════════════╗
║        BIOMETRIC ANALYSIS COMPLETE       ║
╚══════════════════════════════════════════╝
  Time Taken  : 8.42 seconds
  Accuracy    : 100.0%
  Speed (WPM) : 71.2
  Stress Score: 35.6

  ESTIMATED STATE: BALANCED (Normal Alertness)
  → Healthy alertness. Take a short break if needed.
════════════════════════════════════════════
```

---

## 👤 Author

**DILRAG MADHURESH V**  
MCA (AI/ML) — Roll No: 25MCAR0266

---

## 📄 License

This project is for academic purposes.
