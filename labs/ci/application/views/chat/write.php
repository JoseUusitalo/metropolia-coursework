<?php echo validation_errors(); ?>

<?php echo form_open('chat/write'); ?>

    <label for="name">Nickname</label>
    <input type="input" name="name" /><br />

    <label for="text">Message</label>
    <textarea name="text"></textarea><br />

    <input type="submit" name="submit" value="Create chat message" />

</form>