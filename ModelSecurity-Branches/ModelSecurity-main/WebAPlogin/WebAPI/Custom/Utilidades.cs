using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;
using System.Text;
using WebAPI.Models;

namespace WebAPI.Custom
{
    public class Utilidades
    {
        private readonly IConfiguration _configuration;
        public Utilidades(IConfiguration configuration)
        {//acceder a la configuraicon qe hay en appsettings.json
            _configuration = configuration;
        }

        public string encriptarSHA256(string texto)
        {
            using (SHA256 sha256Hash = SHA256.Create())// Crea una instancia del algoritmo de hash SHA256

            {
                byte[] bytes = sha256Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));// Calcula el hash del texto recibido como parámetro, convirtiéndolo antes a bytes con codificación UTF8

                // Convertir el array de bytes a string
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < bytes.Length; i++)
                {
                    builder.Append(bytes[i].ToString("x2"));  // Convierte cada byte a una representación en hexadecimal de dos dígitos (e.g., "a1", "ff", etc.)
                }

                return builder.ToString();// Retorna el hash resultante como una cadena de te
            }
        }

        public string generarJWT(Usuario modelo)
        {
            // Crear la información del usuario que se incluirá en el token (los "claims" o afirmaciones)
            var userClaims = new[]
            {
                new Claim(ClaimTypes.NameIdentifier, modelo.IdUsuario.ToString()),// Identificador único del usuario
                new Claim(ClaimTypes.Email, modelo.Correo!)// Correo electrónico del usuario

            };

            var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:key"]!));// Crear la clave de seguridad simétrica usando la llave secreta del archivo de configuración
            var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256Signature);// Crear las credenciales de firma con el algoritmo HMAC-SHA256

            //crear detalle del token// "Configurar y crear el JWT (token) incluyendo los claims, tiempo de expiración y credenciales de firma"

            var jwtConfig = new JwtSecurityToken(
                claims: userClaims,// Afirmaciones del usuario
                expires: DateTime.UtcNow.AddMinutes(10),// Tiempo de expiración del token (10 minutos)
                signingCredentials: credentials// Firma del token
                );
            // Devolver el token en formato string listo para usarse
            return new JwtSecurityTokenHandler().WriteToken(jwtConfig);
        }


    }
}