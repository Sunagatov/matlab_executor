% САМАЯ ПРОСТАЯ ПРОГРАММКА FDTD-МЕТОДА (ТРЕХМЕРНЫЙ СЛУЧАЙ)

function calculateFdtd(lambdaValue, QValue, QtValue, QTValue, LxConst,  LyConst, LzConst)
											   % очистка памяти
	% электромагнитные константы (все отнесено к микрону)
	lv=2.99792458e14;                                                   % скорость света в вакууме
	EPSo=8.8541878174e-18;                                    % диэлектрическая константа
	MUo=1.2566370614e-12;                                     % магнитная константа

	% параметры среды
	lambda=lambdaValue;                                                                              % длина падающей волны в микронах
	Lx=LxConst*lambda; Ly=LyConst*lambda; Lz=LzConst*lambda;                             % линейные размеры области

	% дискретизация сетки по пространству и времени
	Q =QValue;             % число узлов сеточной области на длину волны (по пространству)
	Qt=QtValue;            % число узлов сеточной области на длину волны (по времени)
	QT=QTValue;              % "длительность" запускаемого цуга в длинах волн

	Nx=fix(Ly*Q)+1; Ny=fix(Ly*Q)+1; Nz=fix(Lz*Q)+1;   % длина сеточной области в узлах (по пространству)
	Nt=fix(Qt*QT);                                          % дискретизация сетки по времени
	hx=Lx/(Nx-1); hy=Ly/(Ny-1); hz=Lz/(Nz-1);               % шаги по пространству 
	ht=lambda/Qt/lv;                                    % шаг по времени
	locx=fix(Nx/2)+1; locy=fix(Ny/2)+1; locz=fix(Nz/2)+1;  % нахождение источника излучения

	ie=Nx-1;    %number of grid cells and Ex samples along x-direction
	je=Ny-1;    %number of grid cells and Ey samples along y-direction
	ke=Nz-1;    %number of grid cells and Ez samples along z-direction

	ib=Nx;    %grid boundary coordinates
	jb=Ny;    
	kb=Nz;   

	Ex=zeros(ie,jb,kb);
	Ey=zeros(ib,je,kb);
	Ez=zeros(ib,jb,ke);
	Hx=zeros(ib,je,ke);
	Hy=zeros(ie,jb,ke);
	Hz=zeros(ie,je,kb);

	% шаги схемы и константы
	c1=ht/MUo; c2=ht/EPSo; c5=2*pi*ht*lv/lambda;

	% создание полей

	epsilon=epsValue; % распространение происходит флинт стекле

	A=exp(0.0*i); % комплексная амплитуда падающей волны

	% разностная схема Yee
	for t=1:Nt
	   %***********************************************************************
	   %     Update magnetic fields
	   %***********************************************************************

	   Hx(2:ie,1:je,1:ke)=Hx(2:ie,1:je,1:ke)+...
					   c1*((Ey(2:ie,1:je,2:kb)-Ey(2:ie,1:je,1:ke))/hz+...
						   (Ez(2:ie,1:je,1:ke)-Ez(2:ie,2:jb,1:ke))/hy);
					
	   Hy(1:ie,2:je,1:ke)=Hy(1:ie,2:je,1:ke)+...
					   c1*((Ex(1:ie,2:je,1:ke)-Ex(1:ie,2:je,2:kb))/hz+...
						   (Ez(2:ib,2:je,1:ke)-Ez(1:ie,2:je,1:ke))/hx);
					
	   Hz(1:ie,1:je,2:ke)=Hz(1:ie,1:je,2:ke)+...
					   c1*((Ex(1:ie,2:jb,2:ke)-Ex(1:ie,1:je,2:ke))/hy+...
						   (Ey(1:ie,1:je,2:ke)-Ey(2:ib,1:je,2:ke))/hx);

	   %***********************************************************************
	   %     Update electric fields
	   %***********************************************************************

	   Ex(1:ie,2:je,2:ke)=Ex(1:ie,2:je,2:ke)+...
				  c2*((Hz(1:ie,2:je,2:ke)-Hz(1:ie,1:je-1,2:ke))/hy+...
				  (Hy(1:ie,2:je,1:ke-1)-Hy(1:ie,2:je,2:ke))/hz)./epsilon(1:ie,2:je,2:ke);

	   Ey(2:ie,1:je,2:ke)=Ey(2:ie,1:je,2:ke)+...
				  c2*((Hx(2:ie,1:je,2:ke)-Hx(2:ie,1:je,1:ke-1))/hz+...
				  (Hz(1:ie-1,1:je,2:ke)-Hz(2:ie,1:je,2:ke))/hx)./epsilon(2:ie,1:je,2:ke);
						
	   Ez(2:ie,2:je,1:ke)=Ez(2:ie,2:je,1:ke)+...
				  c2*((Hx(2:ie,1:je-1,1:ke)-Hx(2:ie,2:je,1:ke))/hy+...
				  (Hy(2:ie,2:je,1:ke)-Hy(1:ie-1,2:je,1:ke))/hx)./epsilon(2:ie,2:je,1:ke);

	   Ex(locx,locy,locz)=real(A*exp(-i*(c5*t-pi/2)));  % условие излучения волны
	end

	imagesc(Ex(:,:,fix(Nz/2))); colorbar; % вывод электрического поля
end