function updateClock() {
    // Tạo một đối tượng Date mới để lấy thời gian hiện tại
    var currentTime = new Date();

    // Lấy giờ, phút và giây
    var hours = currentTime.getHours();
    var minutes = currentTime.getMinutes();
    var seconds = currentTime.getSeconds();

    // Định dạng lại chuỗi thời gian để hiển thị đẹp hơn
    var formattedTime = `${hours}:${minutes}:${seconds}`;
    document.getElementById('hourLocal').innerHTML = formattedTime;

}

// Cập nhật thời gian mỗi giây (1000 milliseconds)
setInterval(updateClock, 1000);


