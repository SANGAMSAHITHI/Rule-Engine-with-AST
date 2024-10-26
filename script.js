function defineRule() {
    const ruleDefinition = document.getElementById("ruleDefinitionInput").value;
    fetch(`/api/rules/define?ruleDefinition=${encodeURIComponent(ruleDefinition)}`, {
        method: 'POST',
    }).then(response => response.json())
      .then(data => document.getElementById("defineResult").textContent = JSON.stringify(data))
      .catch(error => console.error('Error:', error));
}

function assessRule() {
    const context = JSON.parse(document.getElementById("contextInput").value);
    fetch(`/api/rules/assess`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(context),
    }).then(response => response.json())
      .then(result => document.getElementById("assessResult").textContent = "Result: " + result)
      .catch(error => console.error('Error:', error));
}
