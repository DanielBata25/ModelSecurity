using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.Text;
using WebAPI.Custom;
using WebAPI.Models;


var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


builder.Services.AddDbContext<JwtContext>(options =>// Registrar el servicio de DbContext para usar con SQL Server en el contenedor de dependencias de la aplicación
{// Configurar la conexión a la base de datos SQL Server
    // Se obtiene la cadena de conexión llamada "CadenaSQL" desde el archivo de configuración (appsettings.json)
    options.UseSqlServer(builder.Configuration.GetConnectionString("CadenaSQL"));
});

builder.Services.AddSingleton<Utilidades>();// Registrar el servicio de Utilidades como Singleton en el contenedor de dependencias

builder.Services.AddAuthentication(config => {// Configuración de autenticación para la aplicación
    config.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
    config.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
}).AddJwtBearer(config =>// Configurar la autenticación JWT (JSON Web Token) en la aplicación
{
    config.RequireHttpsMetadata = false;
    config.SaveToken = true;
    config.TokenValidationParameters = new TokenValidationParameters
    {//Parametros de validacion del token
        ValidateIssuerSigningKey = true,// Validar que la clave de firma del token sea correcta.
        ValidateIssuer = false,
        ValidateAudience = false, // No validar la audiencia (audience) del token. en el token.
        ValidateLifetime = true,// Validar que el token no haya expirado. Si se establece en true, se comprobará la fecha de expiración (exp) del token.
        ClockSkew = TimeSpan.Zero,
        IssuerSigningKey = new SymmetricSecurityKey
        (Encoding.UTF8.GetBytes(builder.Configuration["Jwt:key"]!)) // Establece la clave simétrica que se utilizará para verificar la firma del token. 
    };
});

builder.Services.AddCors(options =>
{
    options.AddPolicy("NewPolicy", app =>
    {
        app.AllowAnyOrigin().AllowAnyHeader().AllowAnyMethod();
    });
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseCors("NewPolicy");
app.UseAuthentication();
app.UseAuthorization();

app.MapControllers();

app.Run();