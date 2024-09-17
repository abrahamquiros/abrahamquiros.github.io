using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace wordle
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Lista de palabras a adivinar
            string[] palabras = { "mango", "perro", "cielo", "fuego", "roble", "delta", "fuerte",
        "techo", "limón", "bruma", "ronda", "papel", "fruta" };


            // Seleccionar aleatoriamente una palabra de la lista
            string palabraSecreta = SeleccionarPalabraSecreta(palabras);

            
                // Mostrar mensaje de bienvenida
                Console.WriteLine("¡Bienvenido a Wordle!");

            do
            {
                Console.WriteLine("Adivina la palabra de 5 letras. Tienes 6 intentos.");

                // Bucle principal del juego
                for (int intento = 1; intento <= 6; intento++)
                {
                    // Obtener la palabra propuesta por el jugador
                    string palabraPropuesta = Console.ReadLine().ToLower(); // Convertir a minúsculas para facilitar la comparación

                    // Verificar y mostrar el resultado del intento
                    MostrarResultado(palabraSecreta, palabraPropuesta);


                    // Si la palabra es correcta, terminar el juego
                    if (palabraPropuesta == palabraSecreta)
                    {
                        Console.WriteLine($"¡Felicidades! Has adivinado la palabra en {intento} intento/s.");

                        int record = 6;

                        if (intento < record)
                        {
                            Console.WriteLine("Enhorabuena has alcanzado un nuevo record");
                        }

                        return;
                    }

                }

                // Mostrar la palabra correcta al finalizar los intentos
                Console.WriteLine($"Lo siento, no has adivinado. La palabra correcta era: {palabraSecreta}");

            } while (repetir());



        }

        // Función para seleccionar aleatoriamente una palabra de la lista
        static string SeleccionarPalabraSecreta(string[] palabras)
        {
            Random random = new Random();

            int indice = random.Next(palabras.Length);

            return palabras[indice];

        }

        // Función para mostrar el resultado del intento
        static void MostrarResultado(string palabraSecreta, string palabraPropuesta)
        {
            // Comparar letra por letra y mostrar el resultado en cada intento
            for (int i = 0; i < palabraSecreta.Length; i++)
            {
                char letraSecreta = palabraSecreta[i];
                char letraPropuesta = i < 5 ? palabraPropuesta[i] : '_'; //palabraPropuesta.Length


                if (letraPropuesta == letraSecreta)
                {
                    Console.Write(char.ToUpper(letraPropuesta)); // Letra correcta y en la posición correcta

                }
                else if (palabraSecreta.Contains(letraPropuesta.ToString()))
                {
                    Console.Write(char.ToLower(letraPropuesta)); // Letra correcta pero en posición incorrecta

                }
                else
                {
                    Console.Write("_"); // Letra incorrecta

                }

            }

            Console.WriteLine(); // Nueva línea para separar los resultados de cada intento
        }

        static bool repetir()
        {
            Console.WriteLine("Deseas volver a juagar (si 's' o no 'n')");
            char respuesta = char.Parse(Console.ReadLine().ToLower());

            if (respuesta == 's')
            {
                return true;
            }
            else 
            { 
                return false;
            }

        }
    }
}
