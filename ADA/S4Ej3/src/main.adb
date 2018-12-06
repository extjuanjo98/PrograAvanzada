with Text_IO;
with Monitor;use Monitor;
procedure Main is
   --MAX: constant Integer:=40;
   task type Persona;
   feriante:variableControl;

   task body Persona is
   begin
      feriante.pedirTurno;
      feriante.entrarAtraccion;
      delay 5.0;
      feriante.salirAtraccion;
   end Persona;

  -- procedure Lanzar is
  --    p:Persona;
  -- begin
   --   null;
   --end Lanzar;


   p1,p2,p3,p4,p5,p6,p7,p8,p9,p0:Persona;
   p11,p12,p13,p14,p15,p16,p17,p18,p19,p10:Persona;
   p21,p22,p23,p24,p25,p26,p27,p28,p29,p20:Persona;
   p31,p32,p33,p34,p35,p36,p37,p38,p39,p30:Persona;
begin
   --for i in 1..MAX
   --loop
     -- Lanzar;
   --end loop;

   null;
end Main;
