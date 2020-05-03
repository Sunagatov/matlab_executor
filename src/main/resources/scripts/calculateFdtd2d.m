% САМАЯ ПРОСТАЯ ПРОГРАММКА FDTD-МЕТОДА (ДВУМЕРНЫЙ СЛУЧАЙ)

function calculateFdtd(lambdaValue, QValue, QtValue, QTValue, LyConst, LzConst)

		% электромагнитные константы (все отнесено к микрону)
	lv=2.99792458e14;                                                   % скорость света в вакууме
	EPSo=8.8541878174e-18;                                    % диэлектрическая константа
	MUo=1.2566370614e-12;                                     % магнитная константа

	% параметры среды
	lambda=lambdaValue;                                         % длина падающей волны в микронах
	Ly=LyConst*lambda; Lz=LzConst*lambda;                             % линейные размеры области

	% дискретизация сетки по пространству и времени
	Q =QValue;             % число узлов сеточной области на длину волны (по пространству)
	Qt=QtValue;            % число узлов сеточной области на длину волны (по времени)
	QT=QTValue;              % "длительность" запускаемого цуга в длинах волн

	Ny=fix(Ly*Q)+1; Nz=fix(Lz*Q)+1;   % длина сеточной области в узлах (по пространству)
	Nt=fix(Qt*QT);                                          % дискретизация сетки по времени
	hy=Ly/(Ny-1); hz=Lz/(Nz-1);               % шаги по пространству 
	ht=lambda/Qt/lv;                                    % шаг по времени
	locy=fix(Ny/2)+1; locz=fix(Nz/2)+1;  % нахождение источника излучения

	% шаги схемы и константы
	c1=ht/hz/MUo; c2=ht/hy/MUo; c3=ht/hy/EPSo; c4=ht/hz/EPSo; c5=2*pi*ht*lv/lambda;

	% создание полей
	Ex=zeros(Ny,Nz);  Hy=zeros(Ny-2,Nz-1); Hz=zeros(Ny-1,Nz-2); 
	Eps=epsValue; % распространение происходит в кварце

	A=exp(0.0*i); % комплексная амплитуда падающей волны

	% разностная схема Yee
	for t=1:Nt
	   Hy=Hy-c1*(Ex(2:Ny-1,2:Nz)-Ex(2:Ny-1,1:Nz-1));  % поиск Hy    
	   Hz=Hz+c2*(Ex(2:Ny,2:Nz-1)-Ex(1:Ny-1,2:Nz-1)); % поиск Hz
	   Ex(2:Ny-1,2:Nz-1)=Ex(2:Ny-1,2:Nz-1)+(c3*(Hz(2:Ny-1,1:Nz-2)-Hz(1:Ny-2,1:Nz-2))- ...
				 c4*(Hy(1:Ny-2,2:Nz-1)-Hy(1:Ny-2,1:Nz-2)))./Eps(2:Ny-1,2:Nz-1); % поиск Ex

	   Ex(locy,locz)=real(A*exp(-i*(c5*t-pi/2)));  % условие излучения плоской волны с равномерным фронтом и пропусканием отраженной волны
	end

	imagesc(Ex); colorbar; % вывод электрического поля

end