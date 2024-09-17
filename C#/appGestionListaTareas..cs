using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace Eje5
{
    internal class Program
    {
        public struct Tarea
        {
            public string nombre;
            public string descripcion;
            public bool completada;
        }

        static List<Tarea> lista = new List<Tarea>();

        static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("1. Añadir tarea");
                Console.WriteLine("2. Eliminar tarea");             
                Console.WriteLine("3. Mostrar lista de tareas");
                Console.WriteLine("4. Modificar tarea");
                Console.WriteLine("5. Marcar tarea como completada");
                Console.WriteLine("6. Salir");
                Console.WriteLine("Selecciona una opción:");
                int option;
                if (!int.TryParse(Console.ReadLine(), out option))
                {
                    Console.WriteLine("Opción no válida. Introduce un número.");
                    continue;
                }
                switch (option)
                {
                    case 1:
                        AddTarea();
                        break;
                    case 2:
                        BorraTarea();
                        break;
                    case 3:
                        MuestraTarea();
                        break;
                    case 4:
                        ModificaTarea();
                        break;
                    case 5:
                        MarcaCompletada();
                        break;
                    case 6:
                        Console.WriteLine("¡Hasta luego!");
                        return;
                    default:
                        Console.WriteLine("Opción no válida: del 1 al 6.");
                        break;
                }
            }
        }

        static void AddTarea()
        {
            Console.WriteLine("Introduzca el nombre de la tarea");
            string nombreTarea = Console.ReadLine();
            Console.WriteLine("Introduzca la descipcion de la tarea");
            string descripcionTarea = Console.ReadLine();

            Tarea nuevaTarea = new Tarea
            {
                nombre = nombreTarea,
                descripcion = descripcionTarea,
                completada = false
            };

            lista.Add(nuevaTarea);
            Console.WriteLine("Tarea añadida a la lista.");
        }

        static void BorraTarea()
        {
            Console.WriteLine("Que tarea deseas borrar (Introduce el núm de tarea):");
            int indice = int.Parse(Console.ReadLine());

            lista.RemoveAt(indice - 1);
            Console.WriteLine($"Tarea {indice} eliminada de la lista.");
        }

        static void MuestraTarea()
        {
            if (lista.Count == 0)
            {
                Console.WriteLine("No hay tareas.");
                return;
            }

            Console.WriteLine("Lista de tareas:");
            for (int i = 0; i < lista.Count; i++)
            {
                Console.WriteLine($"{i + 1}. {lista[i].nombre} - {lista[i].descripcion} " +         
                $" - { (lista[i].completada ? "Completada" : "Pendiente")}");
                // ? operador ternario si es true devuelve Completada si es false Pendiente
            }
        }

        static void ModificaTarea()
        {       
            MuestraTarea();

            Console.WriteLine("Que tarea deseas modificar (Introduce el núm de tarea):");
            int indice = int.Parse(Console.ReadLine());

            if (indice < 1 || indice > lista.Count)
            {
                Console.WriteLine("Índice fuera de rango. Por favor, introduce un número válido.");
                return;
            }

            Tarea tareaModificar = lista[indice - 1];

            Console.WriteLine("Introduzca el nombre de la tarea");
            tareaModificar.nombre = Console.ReadLine();
            Console.WriteLine("Introduzca la descipcion de la tarea");
            tareaModificar.descripcion = Console.ReadLine();

            lista[indice - 1] = tareaModificar;
            Console.WriteLine("Tarea modificada correctamente.");
        }

        static void MarcaCompletada()
        {
            MuestraTarea();
            Console.WriteLine("que tarea deseas marcar como hecha");
            int indice = int.Parse(Console.ReadLine());

            if (indice < 1 || indice > lista.Count)
            {
                Console.WriteLine("Índice fuera de rango. Por favor, introduce un número válido.");
                return;
            }

            Tarea tareaHecha = lista[indice - 1];
            tareaHecha.completada = true;
            lista[indice - 1] = tareaHecha;
            Console.WriteLine("Tarea marcada como hecha");
        }
    }
}
