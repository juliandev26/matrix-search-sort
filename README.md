# Proyecto: Búsqueda y Ordenación en una Matriz 1000x1000

## Descripción
Este proyecto implementa y analiza la eficiencia de distintos algoritmos de búsqueda y ordenación en una matriz de 1000x1000 elementos generados aleatoriamente. Se comparan tiempos de ejecución para evaluar el desempeño de cada técnica.

## Características
- Generación de una matriz de 1000x1000 con números aleatorios entre -1000 y 1000.
- Implementación de tres algoritmos de búsqueda:
  - Búsqueda Secuencial
  - Búsqueda Binaria
  - Búsqueda por Interpolación
- Implementación de seis algoritmos de ordenación:
  - Bubble Sort
  - Insertion Sort
  - Merge Sort
  - Shell Sort
  - Counting Sort
  - Radix Sort
- Medición del tiempo de ejecución de cada algoritmo.

## Requisitos
- Java 21 o superior
- IntelliJ IDEA u otro entorno de desarrollo compatible
- Sistema operativo basado en Linux (ejemplo: Fedora con Wayland)

## Instalación y Ejecución
1. Clonar este repositorio:
   ```sh
   git clone https://github.com/usuario/proyecto-matriz.git
2. Compilar y ejecutar el programa:
   ```
   javac MatrixSearchSort.java
   java MatrixSearchSort

## Resultados Esperados
- Se espera que los algoritmos de ordenación más eficientes (Merge Sort, Radix Sort) superen a los métodos menos eficientes como Bubble Sort. De igual manera, la búsqueda por interpolación debería ser más rápida que la secuencial en distribuciones uniformes.
