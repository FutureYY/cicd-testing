const canvas = document.getElementById("wheel");
const ctx = canvas.getContext("2d");
let angle = 0;

function spin() {
  const input = document.getElementById("names").value.trim();
  if (!input) return;

  const names = input.split("\n").filter(n => n);
  drawWheel(names);

  const winner = names[Math.floor(Math.random() * names.length)];
  document.getElementById("result").innerText = "Winner: " + winner;
}

function drawWheel(names) {
  const slice = 2 * Math.PI / names.length;
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  names.forEach((name, i) => {
    ctx.beginPath();
    ctx.moveTo(200, 200);
    ctx.arc(200, 200, 200, slice * i, slice * (i + 1));
    ctx.fillStyle = `hsl(${i * 360 / names.length}, 70%, 60%)`;
    ctx.fill();

    ctx.save();
    ctx.translate(200, 200);
    ctx.rotate(slice * i + slice / 2);
    ctx.fillStyle = "#000";
    ctx.fillText(name, 100, 0);
    ctx.restore();
  });
}
