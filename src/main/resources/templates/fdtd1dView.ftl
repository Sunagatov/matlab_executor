<form class="form-horizontal" action="calculateFdtd_1D" method="post">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <fieldset>

        <legend>Одномерный случай</legend>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Lambda</label>
            <div class="col-md-4">
                <input id="Lambda" name="Lambda" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Длина волны</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Q</label>
            <div class="col-md-4">
                <input id="Q" name="Q" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Число узлов сеточной области на длину волны (по пространству)</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Qt</label>
            <div class="col-md-4">
                <input id="Qt" name="Qt" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Число узлов сеточной области на длину волны (по времени)</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">QT</label>
            <div class="col-md-4">
                <input id="QT" name="QT" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">"длительность" запускаемого цуга в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Eps</label>
            <div class="col-md-4">
                <input id="Eps" name="Eps" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Распространение</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">LzConst</label>
            <div class="col-md-4">
                <input id="LzConst" name="LzConst" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Линейные размеры области в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="calculateButton"></label>
            <div class="col-md-4">
                <input id="calculateButton" name="calculateButton" class="btn btn-primary" type="submit"
                       value="Рассчитать">
            </div>
        </div>
    </fieldset>
</form>