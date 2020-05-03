<form class="form-horizontal">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <fieldset>

        <legend>Трехмерный случай</legend>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Lambda</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Длина волны</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Q</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Число узлов сеточной области на длину волны (по пространству)</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">QT</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">"длительность" запускаемого цуга в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Qt</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Число узлов сеточной области на длину волны (по времени)</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">Eps</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Распространение</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">LxConst</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Линейные размеры области в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">LyConst</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Линейные размеры области в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="textinput">LzConst</label>
            <div class="col-md-4">
                <input id="textinput" name="textinput" type="text" placeholder="Введите значение"
                       class="form-control input-md" required="">
                <span class="help-block">Линейные размеры области в длинах волн</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="calculateButton"></label>
            <div class="col-md-4">
                <button id="calculateButton" name="calculateButton" class="btn btn-primary">Calculate</button>
            </div>
        </div>
    </fieldset>
</form>