using Microsoft.AspNetCore.Http;

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using WebAPI.Custom;
using WebAPI.Models;
using WebAPI.Models.DTOs;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Authentication.JwtBearer;


namespace WebAPI.Controllers
{
    [Route("api/[controller]")]
    [Authorize] // Indica que es un controlador de API (no MVC tradicional)
    [ApiController]
    public class ProductoController : ControllerBase
    {
        private readonly JwtContext _dbPruebaContext;// Campo privado para el contexto de la base de datos
        public ProductoController(JwtContext dbPruebaContext)// Constructor que inyecta el contexto de base de datos
        {
            _dbPruebaContext = dbPruebaContext;
        }

        [HttpGet]// Define un endpoint GET accesible desde: api/producto/lista
        [Route("Lista")]
        public async Task<IActionResult> Lista()
        {
            var lista = await _dbPruebaContext.Productos.ToListAsync(); // Obtiene todos los productos de la base de datos de forma asincrónica
            return StatusCode(StatusCodes.Status200OK, new { value = lista });// Devuelve la lista con código 200 (OK) y la envuelve en un objeto con propiedad "value"

        }
    }
}